import React from 'react'
import Navbar from '../components/Navbar'
import MovieCard from '../components/MovieCard'

const Home = () => {
  return (
    <div className='w-full' >
        <Navbar/>
        <div className='mx-8 my-8 grid grid-cols-2 justify-evenly gap-9 content-evenly align-middle md:grid-cols-6 '>
          <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
         <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
        <MovieCard movieName="45" rating={4.5} imgUrl='../assets/movie_img.png' releaseDate='1/1/2026' ></MovieCard>
        </div>
         <div className='w-full flex justify-center py-4'>
          <div className='flex justify-between items-center '>
          <button className='hover:scale-105 text-primary-400 bg-primary rounded-lg cursor-pointer px-4 py-2'>prev</button>
          <div className='flex justify-between cursor-pointer'>
            <span className="p-3 py-2 m-1 bg-amber-300 text-white text-center rounded-md">1</span>
            <span className="p-3 py-2 m-1 bg-amber-300 text-white text-center rounded-md">2</span>
            <span className="p-3 py-2 m-1 bg-amber-300 text-white text-center rounded-md">3</span>
          </div>
          <button className='text-primary-400 bg-primary rounded-lg cursor-pointer px-4 py-2'>prev</button>
          </div>
          </div>
       
    </div>
  )
}

export default Home