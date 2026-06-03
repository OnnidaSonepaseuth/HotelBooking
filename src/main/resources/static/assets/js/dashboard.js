window.onload = function () {
    const ctx = document.getElementById('chart');

    if (!ctx) return;

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: chartLabels,
            datasets: [{
                label: 'Bookings',
                data: chartData,
                backgroundColor: 'rgba(13,110,253,0.7)',
                borderRadius: 5
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    display: true
                }
            }
        }
    });
};