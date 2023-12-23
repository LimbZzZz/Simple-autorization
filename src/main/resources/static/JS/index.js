const profile = document.querySelector('.right');
const profileMenu = document.querySelector('.profile__menu-dis')
profile.addEventListener('click', () => {
    profileMenu.classList.toggle("active")
})