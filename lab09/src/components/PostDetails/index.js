import React, { useEffect, useState, useContext } from "react";
import Comment from "../Comment";
import { PostIdContext } from "../../context/PostIdContext";


function PostDetails({onDeletePostClick}) {
    console.log("PostDetails renderred")
    const postId = useContext(PostIdContext);

    const [postDetail, setPostDetail] = useState({});
    const fetchPostById = (postId) => {
        fetch(`http://localhost:8080/api/v1/posts/${postId}`)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            setPostDetail(data);
        })
    }

    useEffect(() => {
        fetchPostById(postId);
    }, [postId]);

    return (
        <div className="container">
            <h1 className="text-center"><u>{postDetail.title}</u></h1>
            <h2 className="text-center">{postDetail.author}</h2>
            <p>{postDetail.content}</p>
            <p>Comments ({postDetail.comments?.length}):</p>
            <ul>
                {postDetail.comments?.map(
                    comment => <li><Comment commentDetails={comment} /></li>
                )}
            </ul>
            <div className="d-flex justify-content-center">
                <button className="btn btn-link text-danger">edit</button>
                <button className="btn btn-link text-danger" onClick={() => onDeletePostClick(postId)}>delete</button>
            </div>
        </div>
    )
}

export default React.memo(PostDetails);