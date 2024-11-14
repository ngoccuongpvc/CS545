

export default function Comment({commentDetails}) {
    console.log("Comment renderred")
    return (
        <p>{commentDetails.name}</p>
    )
}