import React,{useState,useEffect} from "react";
import PostList from "../Post/PostList";
import './Home.css'; 




function Home() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded]= useState(false);
    const [postList, setPostList]=useState([]);

    useEffect(()=>{
        fetch("http://localhost:8585/api/post/list")
        .then(res => res.json())
        .then(
            (result)=>{
                setIsLoaded(true);
                setPostList(result)
            },
            (error)=>{
                setIsLoaded(true);
                setError(error)
            }
        )
    },[])

    if(error){
        return <div>Error!!!</div>
    }else if(!isLoaded){
        return <div>Loading---</div>
    }else{
        return(
            <div className="container">
                     HOME!!
                    
                {postList.map(post=>(
                     <PostList title={post.title} content={post.content}></PostList>
                 ))}
            </div>
        );
    }
}

export default Home;
