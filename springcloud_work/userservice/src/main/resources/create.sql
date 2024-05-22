CREATE TABLE `users`
(
    `user_idx`      BIGINT NOT NULL AUTO_INCREMENT,
    `user_email`    VARCHAR(255) NULL DEFAULT NULL,
    `user_name`     VARCHAR(255) NULL DEFAULT NULL,
    `user_password` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`user_idx`)
) COLLATE='utf8mb4_general_ci'
;