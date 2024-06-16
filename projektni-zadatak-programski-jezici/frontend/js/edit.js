const id = params.get('id')

if(id == null || id === '')
    window.location.href ='./index.html'

const breadcrumb = document.getElementById('breadcrumb')
const sid = document.getElementById('id')
const name = document.getElementById('name')
const surname = document.getElementById('surname')
const contact = document.getElementById('contact')
const department = document.getElementById('department')
const created = document.getElementById('created')
const updated = document.getElementById('updated')

fetch('http://localhost:8000/api/employee/' + id)
.then(rsp=>{
    if(rsp.status === 200)
        return rsp.json()
    alert('No employee found')
    window.location.href = './index.html'
})
.then(data=>{
    breadcrumb.innerText = `${data.name} ${data.surname} `
    sid.value = data.id
    name.value = data.name
    surname.value = data.surname
    contact.value = data.contact

    fetch('http://localhost:8000/api/department')
        .then(rsp =>rsp.json())
        .then(datadept =>{
            datadept.forEach(departments =>{
                const option = document.createElement('option')
                if(departments.id === data.department.id){
                    option.selected = true
                }
                option.value =  departments.id
                option.text = departments.name
                department.appendChild(option)
            })
        })
    created.value = formatDate(data.createdAt)
    updated.value = formatDate(data.updatedAt)

    document.getElementById('save').addEventListener('click', () => {
        fetch(`http://localhost:8000/api/employee/${data.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: name.value,
                surname: surname.value,
                contact: contact.value,
                departmentId: department.value
            })
        })
            .then(rsp=>{
                if (rsp.ok) {
                    window.location.href='./index.html'
                    return
                }

                alert(`Employee edit failed(HTTP ${rsp.status}`)
            })
    })
})