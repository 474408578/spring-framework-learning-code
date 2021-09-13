package com.xschen.spring.annotation.f_typefilter.filter;

import com.xschen.spring.annotation.f_typefilter.color.Green;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author xschen
 */


public class GreenTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 借助 MetadataReader 可以获取到正在扫描的类的信息
     * @param metadataReaderFactory 借助 MetadataReaderFactory 可以获取到 其他类的MetadataReader，
     *                              借助MetadataReader可以获取到指定类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader,
                         MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        return classMetadata.getClassName().equals(Green.class.getName());
    }
}
