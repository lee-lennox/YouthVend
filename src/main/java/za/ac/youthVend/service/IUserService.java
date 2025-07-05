package za.ac.youthVend.service;

import net.bytebuddy.dynamic.DynamicType;
import za.ac.youthVend.domain.User;

public interface IUserService extends IService<User, Long> {
    DynamicType.Builder.RecordComponentDefinition.Optional<User> findByEmail(String email);
}