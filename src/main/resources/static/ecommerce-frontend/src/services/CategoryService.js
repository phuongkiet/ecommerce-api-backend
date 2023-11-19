import axios from "axios";

const CATEGORY_API_BASE_URL = "http://localhost:8080/category";
class CategoryService {
    getCategory(){
        return axios.get(CATEGORY_API_BASE_URL);
    }
}

const categoryService = new CategoryService();

export default categoryService;