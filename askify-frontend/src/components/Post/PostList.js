import React,{useState,useEffect} from "react";
import './PostList.css';

function Post(props){
    const{title,content}=props;
    return(
        <div className="postContainer">
            {title}
            {content}
        </div>
    )
    
}
export default Post;

