const name = document.getElementById('name')
const surname = document.getElementById('surname')
const contact = document.getElementById('contact')

fetch('http://localhost:8000/api/department')
    .then(rsp => rsp.json())
    .then(datadept => {
        datadept.forEach(departments => {
            const option = document.createElement('option')
            option.value = departments.id
            option.text = departments.name
            department.appendChild(option)
        })

        document.getElementById('save').addEventListener('click', () => {


            if (name.value === '' || name.value == null) {
                alert('Employee name cannot be empty')
                return
            }
            if (surname.value === '' || surname.value == null) {
                alert('Employee surname cannot be empty')
                return
            }
            if (contact.value === '' || contact.value == null) {
                alert('Employee contact info cannot be empty')
                return
            }

            fetch('http://localhost:8000/api/employee', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name: name.value,
                    surname: surname.value,
                    contact: contact.value,
                    departmentId: department.value
                })
            }).then(rsp => {
                if (rsp.ok) {
                    window.location.href = './index.html'
                    return
                }

                alert(`Employee creation failed(HTTP ${rsp.status}`)
            })
        })

    })