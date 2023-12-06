package com.shshon.esstudy.common.domain

import java.time.LocalDateTime

data class Auditor(
    val auditedBy: String,
    val auditedAt: LocalDateTime,
) {
    companion object {
        fun now(auditedBy: String): Auditor {
            return Auditor(
                auditedBy = auditedBy,
                auditedAt = LocalDateTime.now(),
            )
        }
    }
}
