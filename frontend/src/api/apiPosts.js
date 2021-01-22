import axios from "axios";

export const gatewayApi = async (username, password, email) => {
  return await axios.post(
    "http://localhost:8762/user-handler/register",
    {
      username: username,
      password: password,
      email: email,
    },
    {
      withCredentials: true,
    }
  );
};

export const postCharToGetQuests = async (character) => {
    
  return await axios.post("http://localhost:56675/api/quest",character,
  {
    headers:{
      'Content-Type': 'application/json',
    },
  crossorigin: true
  }
  ).catch((error) => {
    if (error.response){
      console.log("error.response")
      console.log(error.response)
      
      }else if(error.request){
        console.log("error.request")
        console.log(error.request)
      
      }else if(error.message){
      
        console.log(error.message)
      
      }
  })
}