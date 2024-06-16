const table = document.getElementById('department-table')
const template = document.getElementById('department')


    fetch('http://localhost:8000/api/department')
        .then(rsp=>rsp.json())
        .then(data=> {
            data.forEach(department => {
                const copy = template.content.cloneNode(true)
                copy.querySelector('.id').innerText = department.id
                copy.querySelector('.name').innerText = department.name
                copy.querySelector('.createdAt').innerText = formatDate(department.createdAt)
                copy.querySelector('.updatedAt').innerText = formatDate(department.updatedAt)
                copy.querySelector('.edit').href = `./edit-department.html?id=${department.id}`
                copy.querySelector('.remove').addEventListener('click',()=>{
                    if(confirm(`Do you want to remove department ${department.name} ?`)){
                        fetch(`http://localhost:8000/api/department/${department.id}`, {
                            method: 'DELETE',

                        })
                            .then(rsp=>{
                                if (rsp.status ===204) {
                                    window.location.href='./department.html'
                                    return
                                }

                                alert(`Department removal failed(HTTP ${rsp.status}`)
                            })
                    }
                })
                table.appendChild(copy)
            })
        })

