import React from 'react'
import LayoutHead from "../components/LayoutHead";
import fetch from 'isomorphic-unfetch';
import GoodCard from "../components/GoodCard";


const Home = (props) => (
  
          
  <div>
    <div className="header">
    <div className="logo"><a href="/"><img src="img/logo-inner.png" alt=""/></a></div>
    </div>
    <div className="banner"><a href="/black-friday">
              <picture className="banner">
                <source className="banner" srcset="img/photos/banner-smaller.png" data-main="data-main"/>
                <source srcset="img/photos/new-main-slider-img-4-1.jpg"/><img/>
              </picture></a></div>
    <LayoutHead title="BLACK FRIDAY / store"/>
    <div className="hero">

        <div id="grid">
          {props.goods.data.map(
              (good, index) => <GoodCard key={index} {...good} />
          )}
        </div>
    </div>


    <style jsx>{`
    .banner img{
      margin-left:-8px;
      margin-right:-8px;
      width:100vw;
      max-width:100vw;
    }
      .logo {padding:20px;}
      .header {
        margin-top:-8px;
        margin-left:-8px;
        margin-right:-8px;
        top:0;
        left:0;
        right:0;
        background: #000;
      }
      .hero {
        width: 100%;
        color: #333;
      }
      #grid {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
        grid-gap: 2vw;
      }
    `}</style>
  </div>
);

Home.getInitialProps = async function() {
    const res = await fetch('http://chelhack.deletestaging.com/goods');
    //const res = await fetch('http://localhost:8080/api');
    const data = await res.json();

    // console.log(`get Data `, data);

    return {
        goods: data
    };
};
export default Home
