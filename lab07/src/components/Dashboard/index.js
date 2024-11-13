import { useEffect, useState } from "react"
import Posts from "../Posts"
import PostDetails from "../PostDetails";
import AddPost from "../AddPost";

export default function Dashboard() {
    const [posts, setPosts] = useState([]);

    const fetchPosts = () => {
        fetch("http://localhost:8080/api/v1/posts")
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            setPosts(data);
        })
    }

    useEffect(() => {
        fetchPosts()
    }, []);

    const [input, setIput] = useState("");
    const [selectedPostId, setSelectedPostId] = useState(undefined);

    const onChangeNameButtonClick = (e) => {
        e.preventDefault();
        setPosts(posts => [
            {
                ...posts[0],
                title: input,                
            },
            ...posts.slice(1, posts.length)
        ]);
        setIput("");
    }

    const onPostClick = (post) => {
        setSelectedPostId(post.id);
    }

    const onDeletePostClick = (postId) => {
        fetch(`http://localhost:8080/api/v1/posts/${postId}`,
            {
                method: "DELETE"
            }
        ).then((response) => {
            setSelectedPostId(undefined);
        }).finally(() => {
            fetchPosts();
        })
        
    }

    const onCreatePost = (author, title, content) => {
        fetch("http://localhost:8080/api/v1/posts", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                author: author,
                title: title,
                content: content
            })
        }).then((response) => {

        }).finally(() => {
            fetchPosts();
        })
    }

    return (
        <div className="container">
            <Posts posts={posts} onPostClick={onPostClick} />
            {/* <form>
                <div className="mb-3">
                    <input type="text" value={input} onChange={(e) => {setIput(e.target.value)}} />
                </div>
                <div className="mb-3">
                    <button onClick={onChangeNameButtonClick}>
                        Change Name
                    </button>
                </div>
            </form> */}
            {
                (selectedPostId !== undefined) && (
                    <div className="w-50 border border-3 mx-auto mb-3">
                        <PostDetails 
                            postId={selectedPostId}
                            onDeletePostClick={onDeletePostClick.bind(this, selectedPostId)}
                        />
                    </div>
                )
            }
            <div className="w-50 mx-auto">
                <AddPost onCreatePost={onCreatePost} />
            </div>
        </div>
    )
}