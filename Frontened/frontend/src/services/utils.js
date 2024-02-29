
const SERVER_URL="http://localhost:8444"

export function createUrl(path){
    return `${SERVER_URL}/${path}`
    }
        
// export function createUrl(path){
//     return `${SERVER_URL}/${path}`
//     }

export function createError(error){
    return {status:'error',error}

}