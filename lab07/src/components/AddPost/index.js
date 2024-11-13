import { useState } from "react"

export default function AddPost({onCreatePost}) {
    const [author, setAuthor] = useState("");
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        onCreatePost(author, title, content);
        setAuthor(() => "");
        setTitle(() => "");
        setContent(() => "");
    }

    const onClearButtonClicked = (e) => {
        e.preventDefault();
        setAuthor(() => "");
        setTitle(() => "");
        setContent(() => "");
    }

    return (
        <form onSubmit={handleSubmit}>
            <h1 className="text-center">Create New Post</h1>
            <div className="form-group row mb-3">
                <label htmlFor="author" className="col-form-label col-2">Author</label>
                <div className="col-10">
                    <input
                        id="author"
                        type="text"
                        className="form-control"
                        value={author}
                        onChange={(e) => setAuthor(e.target.value)}
                    />
                </div>
            </div>
            <div className="form-group row mb-3">
                <label htmlFor="title" className="col-form-label col-2">Title</label>
                <div className="col-10">
                    <input
                        id="title"
                        type="text"
                        className="form-control"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                    />
                </div>
            </div>
            <div className="form-group row mb-3">
                <label htmlFor="content" className="col-form-label col-2">Content</label>
                <div className="col-10">
                    <input
                        id="content"
                        type="text"
                        className="form-control"
                        value={content}
                        onChange={(e) => setContent(e.target.value)}
                    />
                </div>
            </div>
            <div className="d-flex justify-content-center">
                <button
                    type="button"
                    className="btn btn-warning me-3"
                    onClick={onClearButtonClicked}
                >
                    Clear
                </button>
                <button
                    type="submit"
                    className="btn btn-primary"
                >Create Post</button>
            </div>
        </form>
    )
}