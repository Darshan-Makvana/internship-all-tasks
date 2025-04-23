document.addEventListener("DOMContentLoaded", () => {
    const cards = document.querySelectorAll(".team-card");

    cards.forEach(card => {
        card.addEventListener("click", () => {
            alert("More details coming soon!"); // Replace this with a modal pop-up later
        });
    });
});
