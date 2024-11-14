import React, { useRef } from "react"

function AddPost({onCreatePost}) {

    const formRef = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();
        const author = formRef.current["author"].value;
        const title = formRef.current["title"].value;
        const content = formRef.current["content"].value;
        onCreatePost(author, title, content);
        clearFormInputs();
    }

    const clearFormInputs = () => {
        formRef.current["author"].value = "";
        formRef.current["title"].value = "";
        formRef.current["content"].value = "";
    }
    const onClearButtonClicked = (e) => {
        e.preventDefault();
        clearFormInputs();
    }

    return (
        <form onSubmit={handleSubmit} ref={formRef}>
            <h1 className="text-center">Create New Post</h1>
            <div className="form-group row mb-3">
                <label htmlFor="author" className="col-form-label col-2">Author</label>
                <div className="col-10">
                    <input
                        id="author"
                        name="author"
                        type="text"
                        className="form-control"
                    />
                </div>
            </div>
            <div className="form-group row mb-3">
                <label htmlFor="title" className="col-form-label col-2">Title</label>
                <div className="col-10">
                    <input
                        id="title"
                        name="title"
                        type="text"
                        className="form-control"
                    />
                </div>
            </div>
            <div className="form-group row mb-3">
                <label htmlFor="content" className="col-form-label col-2">Content</label>
                <div className="col-10">
                    <input
                        id="content"
                        name="content"
                        type="text"
                        className="form-control"
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

export default React.memo(AddPost);