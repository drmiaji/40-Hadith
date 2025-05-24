function onWindowClick(e) {
    const tocTitle = document.querySelector(".toc .title");
    const tocList = document.getElementById("toc-ul");

    if (tocTitle && (e.target === tocTitle || tocTitle.contains(e.target))) {
        if (tocList) {
            tocList.style.display = tocList.style.display === "none" ? "block" : "none";
        }
    }
}

// All DOMContentLoaded logic in one place:
document.addEventListener("DOMContentLoaded", function() {
    console.log("DOM loaded, setting up theme toggle...");

    // Theme toggle - FIXED VERSION
    var toggle = document.getElementById('themeToggle');
    if (toggle) {
        toggle.onclick = function(e) {
            e.preventDefault();
            e.stopPropagation();

            const html = document.documentElement;
            console.log("Before toggle - classes:", html.className);
            console.log("Has dark class:", html.classList.contains('dark'));

            // Simple toggle - if it has 'dark', remove it; if not, add it
            if (html.classList.contains('dark')) {
                html.classList.remove('dark');
                console.log("Removed dark class - switched to LIGHT mode");
            } else {
                html.classList.add('dark');
                console.log("Added dark class - switched to DARK mode");
            }

            console.log("After toggle - classes:", html.className);
            console.log("Has dark class now:", html.classList.contains('dark'));

            // Force repaint
            html.style.display = 'none';
            html.offsetHeight; // Trigger reflow
            html.style.display = '';

            return false;
        };

        console.log("Theme toggle setup complete");
        console.log("Initial theme:", document.documentElement.classList.contains('dark') ? 'DARK' : 'LIGHT');
    } else {
        console.error("Theme toggle button not found!");
    }

    // Go to top button
    var btn = document.getElementById("goTopBtn");
    if (btn) {
        window.onscroll = function() {
            if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
                btn.style.display = "block";
            } else {
                btn.style.display = "none";
            }
        };
        btn.onclick = function() {
            window.scrollTo({top: 0, behavior: "smooth"});
        };
        btn.style.display = "none"; // Hide by default
    }
});

window.addEventListener("click", onWindowClick);