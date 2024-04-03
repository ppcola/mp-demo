package com.example.mp.service.impl;

import com.example.mp.entity.Product;
import com.example.mp.mapper.ProductMapper;
import com.example.mp.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xi
 * @since 2024-04-03
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
