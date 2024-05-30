
import Header from './Header';
import Nav from './Nav';
import Footer from './Footer';
import Home from './Home';
import NewPost from './NewPost';
import PostPage from './PostPage';
import About from './About';
import Missing from './Missing';
import {Routes, Route, useHistory} from 'react-router-dom';
import {useState, useEffect} from 'react';

function App() {
  const [posts, setPosts] = useState([
    {
      id: 1,
      title: "My First Post",
      datetime: "July 01, 2021 11:17:36 AM",
      body: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis consequatur expedita, assumenda similique non optio! Modi nesciunt excepturi corrupti atque blanditiis quo nobis, non optio quae possimus illum exercitationem ipsa!"
    },
    {
      id: 2,
      title: "My 2nd Post",
      datetime: "July 01, 2021 11:17:36 AM",
      body: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis consequatur expedita, assumenda similique non optio! Modi nesciunt excepturi corrupti atque blanditiis quo nobis, non optio quae possimus illum exercitationem ipsa!"
    },
    {
      id: 3,
      title: "My 3rd Post",
      datetime: "July 01, 2021 11:17:36 AM",
      body: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis consequatur expedita, assumenda similique non optio! Modi nesciunt excepturi corrupti atque blanditiis quo nobis, non optio quae possimus illum exercitationem ipsa!"
    },
    {
      id: 4,
      title: "My Fourth Post",
      datetime: "July 01, 2021 11:17:36 AM",
      body: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis consequatur expedita, assumenda similique non optio! Modi nesciunt excepturi corrupti atque blanditiis quo nobis, non optio quae possimus illum exercitationem ipsa!"
    }
  ]);
  const [search, setSearch] = useState('');
  const [searchResult, setSearchResult] = useState([]);

  const handleDelete = (id) => {
    const postList = posts.filter(post => post.id !== id);
    setPosts(postList);
  }

  return (
    <div className="App">
        <Header title="React JS Blog"/>
        <Nav search={search} setSearch={setSearch} />

        <Routes>
          <Route path='' element={<Home posts={posts} />} />
          <Route path='/new' element={<NewPost />} />
          <Route path='/p/:id' element={<PostPage
          posts={posts}
          handleDelete={handleDelete}
          />} />
          <Route path='/a' element={<About />} />
          <Route path='/m' element={<Missing />} />
        </Routes>

        <Footer />
    </div>
  );
}

export default App;
