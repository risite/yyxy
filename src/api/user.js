import request from '@/utils/request'

const user = {

  // 用户
  getUser() {
    return request({
      url: '/user',
      method: 'get'
    })
  }
}

export default user