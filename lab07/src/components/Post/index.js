export default function Post({id, title, author, onPostClick}) {

    return (
        <div className="post text-white p-3 me-3 mb-3" onClick={() => onPostClick({id})}>
            <p>Id: {id}</p>
            <p>Title: {title}</p>
            <p>Author: {author}</p>
        </div>
    )
}