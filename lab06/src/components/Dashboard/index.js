import { useState } from "react"
import Posts from "../Posts"
import PostDetails from "../PostDetails";

export default function Dashboard() {
    const [posts, setPosts] = useState(
        [
            {
                id: 111,
                title: "Happiness",
                author: "John",
                content: "Happiness is happiness",
            },
            {
                id: 112,
                title: "MIU",
                author: "Dean",
                content: "This is the content in the post…",
            },
            {
                id: 113,
                title: "Enjoy Life",
                author: "Jasmine",
                content: "Hello world!"
            },
        ]
    )

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
        setSelectedPostId(posts.findIndex(p => p.id === post.id));
    }

    return (
        <div className="container">
            <Posts posts={posts} onPostClick={onPostClick} />
            <form>
                <div className="mb-3">
                    <input type="text" value={input} onChange={(e) => {setIput(e.target.value)}} />
                </div>
                <div className="mb-3">
                    <button onClick={onChangeNameButtonClick}>
                        Change Name
                    </button>
                </div>
            </form>
            {
                (selectedPostId !== undefined) && (
                    <PostDetails post={posts[selectedPostId]} />
                )
            }
        </div>
    )
}