const table = document.getElementById('table')
const template = document.getElementById('employee')

fetch('http://localhost:8000/api/employee')
    .then(rsp=>rsp.json())
    .then(data=>{
        data.forEach(employee=>{
            const copy = template.content.cloneNode(true)
            copy.querySelector('.id').innerText = employee.id
            copy.querySelector('.name').innerText = employee.name
            copy.querySelector('.surname').innerText = employee.surname
            copy.querySelector('.contact').innerText = employee.contact
            copy.querySelector('.createdAt').innerText = new Date(employee.createdAt).toLocaleDateString('sr-RS')
            table.appendChild(copy)
        })
    })

