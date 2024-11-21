import { useCallback, useState, useEffect } from "react";
import Post from "../Post";
import PostDetails from "../PostDetails";
import { PostIdContext } from "../../context/PostIdContext";

export default function Posts({}) {
  const onDeletePostClick = useCallback((postId) => {
    fetch(`http://localhost:8080/api/v1/posts/${postId}`, {
      method: "DELETE",
    })
      .then((response) => {
        setSelectedPostId(undefined);
      })
      .finally(() => {
        fetchPosts();
      });
  }, []);
  const fetchPosts = () => {
    fetch("http://localhost:8080/api/v1/posts")
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        setPosts(data);
      });
  };
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetchPosts();
  }, []);

  const [selectedPostId, setSelectedPostId] = useState(undefined);

  const onPostClick = (post) => {
    setSelectedPostId(post.id);
  };
  return (
    <div>
      <PostIdContext.Provider value={selectedPostId}>
        <div className="d-flex justify-content-center">
          {posts.map((post) => (
            <Post
              onPostClick={onPostClick}
              id={post.id}
              title={post.title}
              author={post.author}
            />
          ))}
        </div>
        {selectedPostId !== undefined && (
          <div className="w-50 border border-3 mx-auto mb-3">
            <PostDetails onDeletePostClick={onDeletePostClick} />
          </div>
        )}
      </PostIdContext.Provider>
    </div>
  );
}
