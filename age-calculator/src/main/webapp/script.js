document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form');
    const resultDiv = document.getElementById('result');

    form.addEventListener('submit', async function (event) {
        event.preventDefault();

        const dob = document.getElementById('dob').value;
        const dobDate = new Date(dob);

        try {
            const response = await fetch(window.location.href+'/AgeCalculatorServlet', {
                method: 'POST',
                body: new URLSearchParams({ dob }),
            });

            if (response.ok) {
                const age = await response.text();
                resultDiv.innerHTML = `<p>Your Age is: ${age} years</p>`;
            } else {
                throw new Error('Failed to fetch age data');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    });
});
