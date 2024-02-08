import Hero from '../components/Hero';
// import UserSidebar from '../components/UserSidebar';
import heroImg from '../assests/14.jpg';
import Footer from '../components/Footer';
// import Destination from '../components/Destination';
// import Trip from '../components/Trip';



function Home() {
    return (
        <>
           {/* <UserSidebar> */}
            <Hero
                cName="hero"
                heroImg={heroImg}
                title="Your Journey Your Story"
                text="Choose Your Favourite Destination."
                btnText="Book Tickets"
                url="/bookflight"
                btnClass="show"
            />
           


            {/* </UserSidebar> */}

            <Footer/>
            {/* <Destination /> */}
            {/* <Trip /> */}
         
        </>
    )
}

export default Home;