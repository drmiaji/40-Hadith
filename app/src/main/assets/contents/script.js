document.addEventListener("DOMContentLoaded", function() {
    const modeBtn = document.getElementById("modeToggle");
    const translits = document.querySelectorAll(".transliteration");

    const updateTransliterationDisplay = () => {
        const show = document.body.classList.contains("show-transliteration");
        translits.forEach(el => {
            if (el) {
                el.style.display = show ? "block" : "none";
            }
        });
        if (modeBtn) {
            modeBtn.textContent = show ? "Hide pronunciation" : "Show pronunciation";
        }
    };

    const applyTransliteration = (show) => {
        if (show) {
            document.body.classList.add("show-transliteration");
        } else {
            document.body.classList.remove("show-transliteration");
        }

        try {
            localStorage.setItem("showTransliteration", show ? "true" : "false");
        } catch (e) {
            console.error("Failed to save transliteration preference:", e);
        }

        updateTransliterationDisplay();
    };

    let showTransliteration = false;
    try {
        const savedValue = localStorage.getItem("showTransliteration");
        if (savedValue !== null) {
            showTransliteration = savedValue === "true";
        } else {
            const legacyModeIndex = localStorage.getItem("modeIndex");
            showTransliteration = legacyModeIndex === "0" || legacyModeIndex === "1";
        }
    } catch (e) {
        console.error("Failed to read transliteration preference:", e);
    }

    applyTransliteration(showTransliteration);

    if (modeBtn) {
        modeBtn.addEventListener("click", () => {
            applyTransliteration(!document.body.classList.contains("show-transliteration"));
        });
    }

    const observer = new MutationObserver(updateTransliterationDisplay);
    if (document.body) {
        observer.observe(document.body, {
            attributes: true,
            attributeFilter: ["class"]
        });
    }

    const goTopBtn = document.getElementById("goTopBtn");
    if (goTopBtn) {
        window.addEventListener("scroll", function() {
            const scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
            goTopBtn.style.display = scrollTop > 200 ? "block" : "none";
        });

        goTopBtn.addEventListener("click", function() {
            window.scrollTo({
                top: 0,
                behavior: "smooth"
            });
        });

        goTopBtn.style.display = "none";
    }
});
