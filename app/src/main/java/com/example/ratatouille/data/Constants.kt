package com.example.ratatouille.data

object Constants {
    const val SETTINGS = "settings"
    const val IS_AUTHORIZED = "is_authorized"

    const val DARK_MODE = "dark_mode"
    const val LANGUAGE = "language"
    const val SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/\\`~"

    const val BASE_URL = "https://api-gatewayg2-424868328181.europe-west3.run.app/"

    const val SIGN_UP_END_POINT = "accounts/api/v1/signup/"
    const val VERIFY_END_POINT = "accounts/api/v1/otp/verify/{userId}/"
    const val RESEND_OTP_END_POINT = "accounts/api/v1/otp/resend/{userId}/"
    const val RESEND_OTP_FA_END_POINT = "accounts/api/v1/2fa/otp/resend/{id}/"
    const val EXTRA_INDIVIDUAL_END_POINT = "accounts/api/v1/registration/individual/step-three/"
    const val EXTRA_COMPANY_END_POINT = "accounts/api/v1/registration/company/step-three/"
    const val LOGIN_END_POINT = "accounts/api/v1/login/"
    const val RESET_PASSWORD_END_POINT = "accounts/api/v1/password/reset/"
    const val CONFIRM_PASSWORD_END_POINT =
        "accounts/api/v1/password/reset/confirm/{uidb64}/{token}/"
    const val UPDATE_TOKEN_END_POINT = "accounts/api/v1/token/"
    const val REFRESH_TOKEN_END_POINT = "accounts/api/v1/token/refresh/"

    const val PROFILE_INDIVIDUAL_END_POINT = "accounts/api/v1/profile/individual/"
    const val PROFILE_COMPANY_END_POINT = "accounts/api/v1/profile/company/"
    const val CHANGE_NICKNAME_END_POINT = "accounts/api/v1/change/nickname/"
    const val CHANGE_PASSWORD_END_POINT = "accounts/api/v1/change/password/"
    const val CHANGE_CONTACTS_END_POINT = "accounts/api/v1/change/contacts/{id}/"
    const val REMOVE_ACCOUNT = "accounts/api/v1/delete/account/"
    const val REMOVE_GOOGLE_ACCOUNT = "accounts/api/v1/auth/google/delete/"
    const val REMOVE_FACEBOOK_ACCOUNT = "accounts/api/v1/auth/facebook/delete/"

    const val GOOGLE_SIGN_UP_END_POINT = "accounts/api/v1/auth/google-token/"
    const val FACEBOOK_SIGN_UP_END_POINT = "accounts/api/v1/auth/facebook-token/"

    const val TWO_FACTOR_ACTIVATE_END_POINT = "accounts/api/v1/2fa/activate/"
    const val TWO_FACTOR_DEACTIVATE_END_POINT = "accounts/api/v1/2fa/deactivate/"
    const val TWO_FACTOR_CHANGE_INDIVIDUAL_END_POINT = "accounts/api/v1/2fa/change/"

    // auctions
    const val CREATE_AUCTION_END_POINT = "auctions/api/v1/create/auction/"
    const val CREATE_DRAFT_END_POINT = "auctions/api/v1/create/draft/"
    const val GET_AUCTION_BUYER_END_POINT = "/auctions/api/v1/buyer/dashboard/"
    const val GET_AUCTION_SELLER_END_POINT = "/auctions/api/v1/seller/dashboard/"
    const val AUCTION_LIST_SELLER_END_POINT = "/auctions/api/v1/seller/list/"
    const val AUCTION_LIST_BUYER_END_POINT = "/auctions/api/v1/buyer/list/"
    const val AUCTION_RETRIEVE_END_POINT = "/auctions/api/v1/retrieve/{id}/"
    const val LEAVE_AUCTION_END_POINT = "/auctions/api/v1/leave/{auction_id}/"
    const val CANCEL_AUCTION_END_POINT = "/auctions/api/v1/leave/{auction_id}/"
    const val DELETE_AUCTION_END_POINT = "/auctions/api/v1/delete/{id}/"
    const val BUYER_LEADERBOARD_END_POINT = "/auctions/api/v1/buyer/leaderboard/"
    const val SELLER_LEADERBOARD_END_POINT = "/auctions/api/v1/seller/leaderboard/"


    const val EMAIL_REGEX = "^[a-zA-Z][a-zA-Z0-9-.][a-zA-Z0-9]+@[\\w-]+(\\.[\\w-]+)+[\\w-]{2,4}$"

}


