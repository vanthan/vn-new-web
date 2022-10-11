package com.vanthan.vn.controller;

import com.vanthan.vn.dto.BaseResponse;
import com.vanthan.vn.dto.DataProduct;
import com.vanthan.vn.dto.Paging;
import com.vanthan.vn.dto.ProductItem;
import com.vanthan.vn.service.imp.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController extends AbtractController {

    @Autowired
    ProductService productService;

    @Value("${base.url.authen}")
    private String baseUrl;

    @GetMapping(value = "/products")
    public String getProduct(Paging request, Model model, HttpServletRequest req){

        String token = saveToken.get("token");
        String pageNum = req.getParameter("pageNum");
        String keyword = (String) req.getAttribute("keyword");
        if(pageNum == null){
            pageNum = "0";
        }

        if(keyword == null){
            keyword = "";
        }
        request.setPageNum(Integer.valueOf(pageNum));
        request.setTotalNum(5);

        BaseResponse<DataProduct> response = productService.getProduct(keyword,request, token);
        model.addAttribute("listProducts", response.getBody().getContent());

        req.setAttribute("endP", response.getBody().getTotalPages());
        req.setAttribute("totalElements", response.getBody().getTotalElements());
        req.setAttribute("tag", pageNum);
        req.setAttribute("totalNum", 5);

        return "products/product";
    }

    @GetMapping(value = "/saveProduct")
    public String saveProduct(){
        return "products/addProduct";
    }

    @PostMapping(value = "saveProduct")
    public String saveNewProduct(HttpServletRequest request){

        ProductItem productItem = new ProductItem();

        productItem.setName(request.getParameter("name"));
        productItem.setSku(request.getParameter("sku"));
        productItem.setQuantity(Integer.valueOf(request.getParameter("quantity")));

        productService.saveProduct(productItem, saveToken.get("token"));

        return "redirect:/products";
    }

    @GetMapping(value = "edit-products/{id}")
    public String editProduct(@PathVariable("id") String id, Model model){

        model.addAttribute("product", productService.getProductDetail(id, saveToken.get("token")).getBody());

        return "products/editProduct";
    }

    @PostMapping(value ="edit-products")
    public String editNewProduct(ProductItem productItem, Model model, HttpServletRequest request){

        productItem.setName(request.getParameter("name"));
        productItem.setSku(request.getParameter("sku"));
        productItem.setQuantity(Integer.valueOf(request.getParameter("quantity")));

        productService.editProduct(productItem, request.getParameter("id") ,saveToken.get("token"));

        return "redirect:/products";
    }

    @GetMapping(value = "delete-products/{id}")
    public String deleteProduct(@PathVariable("id") String id){

        productService.deleteProduct(id, saveToken.get("token"));

        return "redirect:/products";
    }
}
