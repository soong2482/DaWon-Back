
function sliderJS(){
document.querySelector('.slider-1 > .page-btns').addEventListener('click', function(event) {
    var target = event.target;

    if (target.tagName === 'DIV') {
        var index = Array.from(target.parentElement.children).indexOf(target);

        target.classList.add('active');
        Array.from(target.parentElement.children).forEach(function(sibling) {
            if (sibling !== target) {
                sibling.classList.remove('active');
            }
        });

        var slider = target.parentElement.parentElement;
        var current = slider.querySelector(' > .slides > div.active');
        var post = slider.querySelector(' > .slides > div:nth-child(' + (index + 1) + ')');

        current.classList.remove('active');
        post.classList.add('active');
    }
});

document.querySelector('.slider-1 > .side-btns').addEventListener('click', function(event) {
    var target = event.target;
    var slider = target.closest('.slider-1');

    if (target.tagName === 'DIV') {
        var index = Array.from(target.parentElement.children).indexOf(target);
        var isLeft = index === 0;

        var current = slider.querySelector(' > .page-btns > div.active');
        var post;

        if (isLeft) {
            post = current.previousElementSibling || slider.querySelector(' > .page-btns > div:last-child');
        } else {
            post = current.nextElementSibling || slider.querySelector(' > .page-btns > div:first-child');
        }

        post.click();
    }
});

setInterval(function() {
    document.querySelector('.slider-1 > .side-btns > div:nth-child(2)').click();
}, 3000);
}
export default sliderJS;