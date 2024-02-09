import Hero from '../components/Hero';
import heroImg from '../assests/15.jpg';
import ContactUs from '../components/ContactUs';

function Contact() {
    return (
        <>
           
            <Hero
                cName="hero-mid"
                heroImg={heroImg}
                title="contact us"
                btnClass="hide"
            />
            <ContactUs />
           
        </>
    )
}

export default Contact;