export async function fetchMovies(pageNumber=1){
    try{
      let data=await fetch(`https://api.themoviedb.org/3/movie/upcoming?page=${pageNumber}`,
        {
            headers:{
                authorization:`Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlNTdhOGJiNDZlOTE0ZmQ5NTdjOTBkNzQ3OTllZmY3NiIsIm5iZiI6MTczNDg0NDI1My4zLCJzdWIiOiI2NzY3OWY1ZDhjYTUzY2M2YTc1ZTMwZmQiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.dxDbu2mU68DiD0dSRUkNzWuExxRc6RjQeqLWiPB2ius`
            }
        }
        );
        data=await data.json();
        // console.log(data);
        return data;
    }
    catch(err){
        console.log(err);
    }
}