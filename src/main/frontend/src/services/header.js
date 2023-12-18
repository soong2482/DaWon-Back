function headerjs(){
    
    const toggleMenu = () => {
        const menu = document.querySelector('.menu');
        const sns = document.querySelector('.sns');
        // 클래스에 active가 있으면 빼주고 없으면 추가
        menu.classList.toggle('active');
        sns.classList.toggle('active');
      };
      document.querySelector('#kakao').addEventListener('click',function kakaotalk(){
        window.open("https://open.kakao.com/o/s6kBd69d");
    })
    document.querySelector('#blog').addEventListener('click',function kakaotalk(){
        window.open("https://blog.naver.com/hyenbu03");
    })
}
export default headerjs;