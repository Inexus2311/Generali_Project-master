<template>

    <div id="addcat">
        <form @submit="addCat()">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" v-model="name" class="form-control" id="name" placeholder="Enter Name">
            </div>
            <div class="form-group">
                <label for="color">Farbe</label>
                <input type="text" v-model ="color" class="form-control" id="color" placeholder="Farbe">


            </div>
            <button type="submit" class="btn btn-primary">Absenden</button>

        </form>

    </div>

</template>

<script>

    import axios from 'axios'

    export default {
        data: function () {
            return {
                name: "Jerry",
                color: "0x00000"
            }
        },

        methods: {
            addCat() {
                axios.post('/api/cats', {
                    name: this.name,
                    color: this.color
                })
                    .then(function () {
                        alert("Katze wurde erfolgreich angelegt")
                    })
                    .catch(e => alert(e));
            }
        }
    }
</script>