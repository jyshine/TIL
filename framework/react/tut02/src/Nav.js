import React from 'react'
import { Link } from 'react-router-dom'

const Nav = ({search, setSearch}) => {
  return (
    <nav className='Nav'>
        <form className='searchForm' onSubmit={(e) => e.preventDefault()}>
          <label htmlFor='search'>
            SEARCH POSTS
          </label>
          <input
            id='search'
            type='text'
            placeholder='Search Posts'
            value={search}
            onChange={(e)=> setSearch(e.target.value)}
          >
          </input>
        </form>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/p">Post</Link></li>
          <li><Link to="/a">About</Link></li>
        </ul>
    </nav>
  )
}

export default Nav