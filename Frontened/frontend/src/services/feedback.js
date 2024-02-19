  import axios from "axios";
  import { createError,createUrl } from "./utils";  

  export  async function submitfeedback(feedbackObject) {
    try {
      const url = createUrl('feedback'); // Adjust the URL endpoint according to your server route
    //   const body = {
    //     feedBack, passengerid , busid
    //   };
      const response = await axios.post(url, feedbackObject);
      console.log(response.data)
      return response.data;
    } catch (ex) {
      return createError(ex);
    }
  }

