import { useEffect, useState, useCallback } from "react"
import Posts from "../Posts"
import PostDetails from "../PostDetails";
import AddPost from "../AddPost";
import {PostIdContext} from "../../context/PostIdContext";

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

    const onPostClick = (post) => {
        setSelectedPostId(post.id);
    }

    const onDeletePostClick = useCallback((postId) => {
        fetch(`http://localhost:8080/api/v1/posts/${postId}`,
            {
                method: "DELETE"
            }
        ).then((response) => {
            setSelectedPostId(undefined);
        }).finally(() => {
            fetchPosts();
        })
        
    }, []);

    const onCreatePost = useCallback((author, title, content) => {
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
    }, []);

    return (
        <PostIdContext.Provider value={selectedPostId}>
            <div className="container">
                <Posts posts={posts} onPostClick={onPostClick} />
                {
                    (selectedPostId !== undefined) && (
                        <div className="w-50 border border-3 mx-auto mb-3">
                            <PostDetails 
                                onDeletePostClick={onDeletePostClick}
                            />
                        </div>
                    )
                }
                <div className="w-50 mx-auto">
                    <AddPost onCreatePost={onCreatePost} />
                </div>
            </div>
        </PostIdContext.Provider>
        
    )
}