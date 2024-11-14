import Post from "../Post"

export default function Posts({posts, onPostClick}) {

    return (
        <div className="d-flex justify-content-center">
            {posts.map(post => <Post onPostClick={onPostClick} id={post.id} title={post.title} author={post.author} />)}
        </div>
    )
}