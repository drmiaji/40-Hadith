document.addEventListener("DOMContentLoaded", function () {
    const html = document.documentElement;
    const modeBtn = document.getElementById("modeToggle");

    const updateMode = () => {
        const isDark = html.classList.contains("dark");
        const showTransliteration = document.body.classList.contains("show-transliteration");

        let text = "";
        if (!isDark && showTransliteration) text = "🌙 উচ্চারণসহ";
        else if (isDark && showTransliteration) text = "🌙 উচ্চারণসহ (ডার্ক)";
        else if (isDark && !showTransliteration) text = "🌙 উচ্চারণবিহীন";
        else text = "☀️ উচ্চারণবিহীন";

        modeBtn.textContent = text;
    };

    const applyMode = (modeIndex) => {
        const modes = [
            { dark: false, translit: true },
            { dark: true, translit: true },
            { dark: true, translit: false },
            { dark: false, translit: false },
        ];
        const mode = modes[modeIndex];

        html.classList.toggle("dark", mode.dark);
        document.body.classList.toggle("show-transliteration", mode.translit);

        try {
            localStorage.setItem("modeIndex", modeIndex);
        } catch (e) {}

        updateMode();
    };

    let modeIndex = 0;
    try {
        modeIndex = parseInt(localStorage.getItem("modeIndex")) || 0;
    } catch (e) {}

    applyMode(modeIndex);

    modeBtn.addEventListener("click", () => {
        modeIndex = (modeIndex + 1) % 4;
        applyMode(modeIndex);
    });

    // Initial transliteration display setup
    const translits = document.querySelectorAll(".transliteration");
    const observer = new MutationObserver(updateMode);
    observer.observe(document.body, { attributes: true, attributeFilter: ["class"] });

    const updateTransliterationDisplay = () => {
        const show = document.body.classList.contains("show-transliteration");
        translits.forEach(el => el.style.display = show ? "block" : "none");
    };

    updateTransliterationDisplay();
    new MutationObserver(updateTransliterationDisplay).observe(document.body, {
        attributes: true,
        attributeFilter: ["class"]
    });

    // Scroll button
    const btn = document.getElementById("goTopBtn");
    if (btn) {
        window.onscroll = function () {
            btn.style.display = (document.documentElement.scrollTop > 200 || document.body.scrollTop > 200) ? "block" : "none";
        };
        btn.onclick = function () {
            window.scrollTo({ top: 0, behavior: "smooth" });
        };
        btn.style.display = "none";
    }
});