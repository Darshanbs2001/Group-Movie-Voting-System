import React, { useEffect, useState } from 'react'
import Navbar from '../components/Navbar'
import MovieCard from '../components/MovieCard'
import {fetchMovies,getPages} from '../services/movieService.js'
const Home = () => {
  const [currentPage,setCurrentPage]=useState(1);
  const [totalPages,setTotalPages]=useState(1);
  const [movies,setMovies]=useState([]);
  const [isLoading,setIsLoading]=useState(false);
  const pages=getPages(totalPages,currentPage);
  useEffect(()=>{
    async function getMovies(){
      setIsLoading(true);
      const results= await fetchMovies(currentPage);
      
      const totalPages=results.total_pages;
      const movies=results.results;
      
      setMovies(movies);
      setTotalPages(totalPages);
      console.log(movies);
      setIsLoading(false);
    }
    getMovies();
  },[currentPage]);
  return(
    <div className='w-full' >
        <Navbar/>
        {isLoading? 
        <img className='mx-auto mt-40' src="https://i.gifer.com/ZZ5H.gif" alt="loading..." />
        :
        (
          <div>
        <div className='mx-8 my-8 grid grid-cols-2 justify-evenly gap-9 content-evenly align-middle md:grid-cols-6 '>
        {
          movies.map((movie)=><MovieCard key={movie.id} id={movie.id} movieName={movie.title} rating={movie.original_language} imgUrl={ `https://image.tmdb.org/t/p/w500/${movie.poster_path}`} releaseDate={movie.release_date}/>)
        }
         </div>
         <div className='w-full flex justify-center py-4'>
          <div className='flex justify-between items-center '>
          <button onClick={()=> setCurrentPage((currentPage)=>currentPage-1) } disabled={currentPage===1} className='hover:scale-105 text-primary-400 bg-primary rounded-lg cursor-pointer px-4 py-2 disabled:bg-gray-400 disabled:text-white '>prev</button>
          <div className='flex justify-between cursor-pointer'>
        

            {
              pages.map((page,index)=>{
              
                return <span key={page} onClick={() => setCurrentPage(page)}  className={currentPage===page?"p-3 py-2 m-1 bg-gray-300 text-white text-center rounded-md":"p-3 py-2 m-1 bg-amber-300 text-white text-center rounded-md"}>{page}</span>
              }
          )
        }
</div>
          <button onClick={()=> setCurrentPage((currentPage)=>currentPage+1) } disabled={currentPage===totalPages} className=' hover:scale-105 text-primary-400 bg-primary rounded-lg cursor-pointer px-4 py-2 disabled:bg-gray-400 disabled:text-white'>next</button>
          </div>
          </div>
          </div>
        )
}       
    </div>
  )
}

export default Home