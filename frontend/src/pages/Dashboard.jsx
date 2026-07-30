import { useState } from "react";
import Editor from "@monaco-editor/react";
import ReactMarkdown from "react-markdown";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { oneDark } from "react-syntax-highlighter/dist/esm/styles/prism";
import api from "../api/api";
import jsPDF from "jspdf";


function Dashboard() {
    const [code, setCode] = useState("");
    const [review, setReview] = useState("");
    const [loading, setLoading] = useState(false);
    const [history, setHistory] = useState([]);


    const handleReview = async () => {
        if (!code.trim()) {
            alert("Please enter some code.");
            return;
        }

        try {
            setLoading(true);

            const response = await api.post("/api/reviews", {
                sourceCode: code,
            });

            const newReview = response.data.review;

            setReview(newReview);

            setHistory((previousHistory) => [
                {
                    id: Date.now(),
                    code,
                    review: newReview,
                },
                ...previousHistory,
            ]);
        } catch (error) {
            console.error(error);
            alert("Review failed.");
        } finally {
            setLoading(false);
        }
    };
    const copyReview = async () => {
        try {
            await navigator.clipboard.writeText(review);
            alert("Review copied!");
        } catch (error) {
            console.error(error);
        }
    };

    const clearEditor = () => {
        setCode("");
        setReview("");
    };
    const downloadPDF = () => {
        if (!review) return;

        const doc = new jsPDF();

        const pageHeight = doc.internal.pageSize.height;
        const margin = 10;
        const lineHeight = 7;

        const lines = doc.splitTextToSize(review, 180);

        let y = margin;

        lines.forEach((line) => {
            if (y > pageHeight - margin) {
                doc.addPage();
                y = margin;
            }

            doc.text(line, margin, y);
            y += lineHeight;
        });

        doc.save("code-review.pdf");
    };

    const logout = () => {
        localStorage.removeItem("token");
        window.location.href = "/";
    };

    return (
        <div style={{ padding: "20px" }}>
            <h1>AI Code Review Assistant</h1>

            <button onClick={logout}>Logout</button>

            <br />
            <br />

            <Editor
                height="400px"
                language="java"
                theme="vs-dark"
                value={code}
                onChange={(value) => setCode(value || "")}
            />

            <br />

            <div
                style={{
                    display: "flex",
                    gap: "10px",
                }}
            >
                <button
                    onClick={handleReview}
                    disabled={loading}
                >
                    {loading ? "Reviewing..." : "Review Code"}
                </button>

                <button
                    onClick={copyReview}
                    disabled={!review}
                >
                    Copy Review
                </button>

                <button
                    onClick={clearEditor}
                    disabled={!code && !review}
                >
                    Clear
                </button>
                <button
                    onClick={downloadPDF}
                    disabled={!review}
                >
                    Download PDF
                </button>
            </div>

            <br />
            <br />

            {review && (
                <div className="review-box">
                    <ReactMarkdown
                        components={{
                            code({ inline, className, children, ...props }) {
                                const match = /language-(\w+)/.exec(className || "");

                                return !inline && match ? (
                                    <SyntaxHighlighter
                                        style={oneDark}
                                        language={match[1]}
                                        PreTag="div"
                                        {...props}
                                    >
                                        {String(children).replace(/\n$/, "")}
                                    </SyntaxHighlighter>
                                ) : (
                                    <code className={className} {...props}>
                                        {children}
                                    </code>
                                );
                            },
                        }}
                    >
                        {review}
                    </ReactMarkdown>
                </div>
            )}
            {history.length > 0 && (
                <div style={{ marginTop: "30px" }}>
                    <h2>Review History</h2>

                    {history.map((item) => (
                        <div
                            key={item.id}
                            style={{
                                padding: "10px",
                                marginBottom: "10px",
                                border: "1px solid gray",
                                borderRadius: "8px",
                            }}
                        >
                            <h3>Review {item.id}</h3>

                            <div
                                style={{
                                    display: "flex",
                                    justifyContent: "space-between",
                                    alignItems: "center",
                                }}
                            >
    <span>
        {new Date(item.id).toLocaleString()}
    </span>

                                <button onClick={() => setReview(item.review)}>
                                    Open Review
                                </button>
                            </div>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
}

export default Dashboard;