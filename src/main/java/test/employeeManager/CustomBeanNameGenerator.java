package test.employeeManager;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

public class CustomBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        if (definition instanceof AnnotatedBeanDefinition){
            return generateFullBeanName((AnnotatedBeanDefinition) definition);
    }
    return definition.getBeanClassName();
}
    private String generateFullBeanName(final AnnotatedBeanDefinition definition){
        return definition.getMetadata().getClassName();
    }

}