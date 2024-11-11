

export default function PostDetails({post}) {

    return (
        <div className="container w-50 border border-3">
            <h1 className="text-center"><u>{post.title}</u></h1>
            <h2 className="text-center">{post.author}</h2>
            <p>{post.content}</p>
            <div className="d-flex justify-content-center">
                <button className="btn btn-link text-danger">edit</button>
                <button className="btn btn-link text-danger">delete</button>
            </div>
        </div>
    )
}