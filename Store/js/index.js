let slideWrapper = document.querySelector('.container');
let slides = document.querySelectorAll('.item');
let totalSlides = slides.length; // item의 갯수


let sliderWidth = slideWrapper.clientWidth; // container의 width
let slideIndex = 0;
let slider = document.querySelector('.slider');

slider.style.width = sliderWidth * totalSlides + 'px';

showSlides()

function showSlides() {
    for (var i = 0; i < slides.length; i++) {
        slider.style.left = -(sliderWidth * slideIndex) + 'px';
    }
    slideIndex++;
    if (slideIndex === totalSlides) {
        slideIndex = 0;
    }
    setTimeout(showSlides, 2000);
}