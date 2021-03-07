package com.xschen.spring.mybatis.demo.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.xschen.spring.mybatis.demo.DaoUtils;
import com.xschen.spring.mybatis.demo.dao.AddressMapper;
import com.xschen.spring.mybatis.demo.dao.CustomerMapper;
import com.xschen.spring.mybatis.demo.domain.Address;
import com.xschen.spring.mybatis.demo.domain.Customer;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author xschen
 */


public class CustomerService {

    /**
     * 创建一个新用户
     * @param name
     * @param phone
     * @return
     */
    public Long register(String name, String phone) {
        // 校验参数合法性
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "name is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(phone), "phone is empty");

        return DaoUtils.execute(sqlSession -> {
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = Customer.builder().name(name).phone(phone).build();
            int affected = mapper.save(customer);
            if (affected <= 0) {
                throw new RuntimeException("save customer fail ....");
            }
            return customer.getId();
        });
    }

    /**
     * 为用户添加地址
     * @param customerId
     * @param street
     * @param city
     * @param country
     * @return
     */
    public Long addAddress(Long customerId, String street, String city, String country) {
        // 检查传入参数是否合法
        Preconditions.checkArgument(customerId > 0, "customerId is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(street), "street is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(city), "city is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(country), "country is empty");

        return DaoUtils.execute(sqlSession -> {
            AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
            Address address = Address.builder().street(street).city(city).country(country).build();
            int affected = mapper.save(address, customerId);
            if (affected <= 0) {
                throw new RuntimeException("save address fail ....");
            }
            return address.getId();
        });
    }

    /**
     * 根据customerId获取用户的所有地址
     * @param customerId
     * @return
     */
    public List<Address> findAllAddress(Long customerId) {
        Preconditions.checkArgument(customerId > 0, "id error");
        return DaoUtils.execute(sqlSession -> {
            AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
            return mapper.findAll(customerId);
        });
    }

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    public Customer find(Long id) {
        Preconditions.checkArgument(id > 0, "id error");
        return DaoUtils.execute(sqlSession -> {
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            return mapper.find(id);
        });
    }

    public Customer findWithAddress(Long id) {
        Preconditions.checkArgument(id > 0, "id error");
        return DaoUtils.execute(sqlSession -> {
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            return mapper.findWithAddress(id);
        });
    }
}
