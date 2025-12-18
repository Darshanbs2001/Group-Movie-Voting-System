import React from 'react'
import Navbar from '../components/Navbar'
import MovieCard from '../components/MovieCard'

const Home = () => {
  return (
    <div  >
        <Navbar/>
        <div className='mx-8 my-4 grid grid-cols-2 md:grid-cols-6 gap-5'>
          <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
        
        </div>
    </div>
  )
}

export default Home